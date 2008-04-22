/***********************************************************************
 * Copyright (c) 2008 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.report.engine.layout.pdf.emitter;

import java.util.ArrayList;
import java.util.Locale;

import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IReportContent;
import org.eclipse.birt.report.engine.layout.pdf.font.FontMappingManager;
import org.eclipse.birt.report.engine.layout.pdf.font.FontMappingManagerFactory;

public class LayoutEngineContext
{

	protected int maxWidth;

	protected int maxHeight;

	protected String format;

	protected IReportContent report;

	protected IContent unresolvedContent;
	
	protected Locale locale;
	
	protected long totalPage = 0;
	protected long pageCount = 0;
	protected long pageNumber = 1;

	public void addUnresolvedContent( IContent content )
	{
		this.unresolvedContent = content;
	}

	public IContent getUnresolvedContent( )
	{
		return unresolvedContent;
	}

	public IReportContent getReport( )
	{
		return report;
	}

	public void setReport( IReportContent report )
	{
		this.report = report;
	}

	public String getFormat( )
	{
		return this.format;
	}

	public void setFormat( String format )
	{
		this.format = format;
	}

	public int getMaxHeight( )
	{
		return maxHeight;
	}

	public int getMaxWidth( )
	{
		return maxWidth;
	}

	public void setMaxHeight( int height )
	{
		this.maxHeight = height;
	}

	public void setMaxWidth( int width )
	{
		this.maxWidth = width;
	}

	protected boolean fitToPage = false;

	public void setFitToPage( boolean fitToPage )
	{
		this.fitToPage = fitToPage;
	}

	public boolean fitToPage( )
	{
		return this.fitToPage;
	}

	protected boolean pageBreakPaginationOnly = false;

	public void setPagebreakPaginationOnly( boolean pageBreakPaginationOnly )
	{
		this.pageBreakPaginationOnly = pageBreakPaginationOnly;
	}

	public boolean pagebreakPaginationOnly( )
	{
		return this.pageBreakPaginationOnly;
	}

	protected int pageOverflow = IPDFRenderOption.CLIP_CONTENT;

	public int getPageOverflow( )
	{
		return this.pageOverflow;
	}

	public void setPageOverflow( int pageOverflow )
	{
		this.pageOverflow = pageOverflow;
	}

	protected int preferenceWidth = 0;

	public void setPreferenceWidth( int preferenceWidth )
	{
		this.preferenceWidth = preferenceWidth;
	}

	public int getPreferenceWidth( )
	{
		return this.preferenceWidth;
	}

	protected boolean textWrapping = true;

	public void setTextWrapping( boolean textWrapping )
	{
		this.textWrapping = textWrapping;
	}

	public boolean getTextWrapping( )
	{
		return this.textWrapping;
	}

	protected boolean fontSubstitution = true;

	public void setFontSubstitution( boolean fontSubstitution )
	{
		this.fontSubstitution = fontSubstitution;
	}

	public boolean getFontSubstitution( )
	{
		return this.fontSubstitution;
	}

	protected boolean bidiProcessing = true;

	public void setBidiProcessing( boolean bidiProcessing )
	{
		this.bidiProcessing = bidiProcessing;
	}

	public boolean getBidiProcessing( )
	{
		return this.bidiProcessing;
	}
	
	protected boolean enableHyphenation = true;
	
	public boolean isEnableHyphenation( )
	{
		return enableHyphenation;
	}
	
	public void setEnableHyphenation( boolean enableHyphenation )
	{
		this.enableHyphenation = enableHyphenation;
	}

	public Locale getLocale( )
	{
		return locale;
	}

	public void setLocale( Locale locale )
	{
		this.locale = locale;
	}

	private FontMappingManager fontManager;

	public FontMappingManager getFontManager( )
	{
		if ( fontManager == null )
		{
			fontManager = FontMappingManagerFactory.getInstance( )
					.getFontMappingManager( format, locale );
		}
		return fontManager;
	}
}
