/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.quotientfamilial.web;
 
import fr.paris.lutece.plugins.quotientfamilial.business.QuotientFamilial;
import fr.paris.lutece.plugins.apipart.business.InformationsFiscales;
import fr.paris.lutece.plugins.quotientfamilial.api.QuotientFamilialAPI;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest; 

/**
 * This class provides the user interface to manage QuotientFamilial xpages ( manage, create, modify, remove )
 */
 
@Controller( xpageName = "quotientfamilial" , pageTitleI18nKey = "quotientfamilial.xpage.quotientfamilial.pageTitle" , pagePathI18nKey = "quotientfamilial.xpage.quotientfamilial.pagePathLabel" )
public class QuotientFamilialXPage extends MVCApplication
{
    // VIEWS
    public static final String VIEW_HOME = "home";
    public static final String VIEW_ETAPE1 = "etape1";
    public static final String VIEW_ETAPE2 = "etape2";
    public static final String VIEW_ETAPE3 = "etape3";

    // ACTIONS
    public static final String ACTION_QUOTIENT_FAMILIAL = "quotientfamilial";

    // TEMPLATES
    private static final String TEMPLATE_HOME = "/skin/plugins/quotientfamilial/home.html";
    private static final String TEMPLATE_ETAPE1 = "/skin/plugins/quotientfamilial/etape1.html";
    private static final String TEMPLATE_ETAPE2 = "/skin/plugins/quotientfamilial/etape2.html";
    private static final String TEMPLATE_ETAPE3 = "/skin/plugins/quotientfamilial/etape3.html";
    
    // PARAMETERS
    private static final String PARAMETER_NUMERO_FISCAL = "numeroFiscal";
    private static final String PARAMETER_REFERENCE_AVIS = "referenceAvis";
    
    // MARKERS
    private static final String MARK_QUOTIENT_FAMILIAL = "quotientFamilial";
    private static final String MARK_INFORMATIONS_FISCALES = "informationsFiscales";
    
    //ERRORS
    private static final String ERROR_NUMERO_FISCAL_EMPTY = "apipart.error.numeroFiscal.empty";
    private static final String ERROR_REFERENCE_AVIS_EMPTY = "apipart.error.referenceAvis.empty";
    private static final String ERROR_NUMERO_FISCAL_SIZE = "apipart.error.numeroFiscal.size";
    private static final String ERROR_REFERENCE_AVIS_SIZE = "apipart.error.referenceAvis.size";
    private static final String ERROR_QUOTIENT_FAMILIAL = "quotientfamilial.error.quotientFamilial";
    
    private static final long serialVersionUID = 1L;
    private QuotientFamilial _quotientFamilial;
    private InformationsFiscales _informationsFiscales;
    private final QuotientFamilialAPI _quotientFamilialAPI = SpringContextService.getBean("quotientfamilial.QuotientFamilialAPI");

    /**
     * Returns the content of the page quotientfamilial.
     * @param request The HTTP request
     * @return The view
     */
    @View( value = VIEW_HOME, defaultView = true )
    public XPage viewHome( HttpServletRequest request )
    {
        return getXPage( TEMPLATE_HOME, request.getLocale(  ) );
    }
    
    /**
     * Returns the content of the page quotientfamilial.
     * @param request The HTTP request
     * @return The view
     */
    @View( VIEW_ETAPE1 )
    public XPage viewEtape1( HttpServletRequest request )
    {
        if(_informationsFiscales == null)
        {
            _informationsFiscales = new InformationsFiscales( );
        }
        Map<String, Object> model = getModel(  );
        model.put( MARK_INFORMATIONS_FISCALES, _informationsFiscales );
        return getXPage( TEMPLATE_ETAPE1, request.getLocale(  ), model );
    }
    
    /**
     * compute the quotient familial by connecting to apipart
     * @param request The HTTP request
     * @return the page quotientfamilial
     */
    @Action( ACTION_QUOTIENT_FAMILIAL )
    public XPage actionQuotientFamilial( HttpServletRequest request )
    {
        _quotientFamilial = null;
        _informationsFiscales.setNumeroFiscal(request.getParameter( PARAMETER_NUMERO_FISCAL ));
        _informationsFiscales.setReferenceAvis(request.getParameter( PARAMETER_REFERENCE_AVIS ));
        boolean formComplete = true;
                
        if ( _informationsFiscales.getNumeroFiscal().equals("") )
        {
            addError( ERROR_NUMERO_FISCAL_EMPTY, getLocale( request ) );
            formComplete = false;
        }
        else if ( _informationsFiscales.getNumeroFiscal().length() < 13)
        {
            addError( ERROR_NUMERO_FISCAL_SIZE, getLocale( request ) );
            formComplete = false;
        }
        
        if ( _informationsFiscales.getReferenceAvis().equals("") )
        {
            addError( ERROR_REFERENCE_AVIS_EMPTY, getLocale( request ) );
            formComplete = false;
        }
        else if ( _informationsFiscales.getReferenceAvis().length() < 13)
        {
            addError( ERROR_REFERENCE_AVIS_SIZE, getLocale( request ) );
            formComplete = false;
        }
        
        if( !formComplete )
        {
            return redirectView( request, VIEW_ETAPE1 );
        }
        else
        {
            _quotientFamilial = _quotientFamilialAPI.getQuotientFamilial(request, _informationsFiscales);
        
            if ( _quotientFamilial == null )
            {
                addError( ERROR_QUOTIENT_FAMILIAL, getLocale( request ) );
                return redirectView( request, VIEW_ETAPE1 );
            }
            else
            {
                return redirectView( request, VIEW_ETAPE2 );
            }
        }
    }
    
    /**
     * Returns the content of the page quotientfamilial.
     * @param request The HTTP request
     * @return The view
     */
    @View( VIEW_ETAPE2 )
    public XPage viewEtape2( HttpServletRequest request )
    {
        if(_informationsFiscales == null)
        {
            _informationsFiscales = new InformationsFiscales( );
        }
        Map<String, Object> model = getModel(  );
        model.put( MARK_QUOTIENT_FAMILIAL, _quotientFamilial );
        return getXPage( TEMPLATE_ETAPE2, request.getLocale(  ), model );
    }
    
    /**
     * Returns the content of the page quotientfamilial.
     * @param request The HTTP request
     * @return The view
     */
    @View( VIEW_ETAPE3 )
    public XPage viewEtape3( HttpServletRequest request )
    {
        if(_informationsFiscales == null)
        {
            _informationsFiscales = new InformationsFiscales( );
        }
        Map<String, Object> model = getModel(  );
        model.put( MARK_QUOTIENT_FAMILIAL, _quotientFamilial );
        return getXPage( TEMPLATE_ETAPE3, request.getLocale(  ), model );
    }
}