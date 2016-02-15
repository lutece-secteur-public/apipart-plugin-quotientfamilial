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
package fr.paris.lutece.plugins.quotientfamilial.business;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * This is the business class for the object QuotientFamilial
 */ 
public class QuotientFamilial implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int _nRevenuFiscalReference;
    private int _nNombreParts;
    private int _nNombrePersonnesCharge;
    private int _nMontantImpot;
    private String _strSituationFamille;
    private String _strAnneeImpots;
    private String _strAnneeRevenus;

    /**
     * Returns the RevenuFiscalReference
     * @return The RevenuFiscalReference
     */
    public int getRevenuFiscalReference( )
    {
        return _nRevenuFiscalReference;
    }

    /**
     * Sets the RevenuFiscalReference
     * @param nRevenuFiscalReference The RevenuFiscalReference
     */ 
    @JsonProperty( "revenuFiscalReference" )
    public void setRevenuFiscalReference( int nRevenuFiscalReference )
    {
        _nRevenuFiscalReference = nRevenuFiscalReference;
    }
    
    /**
     * Returns the NombreParts
     * @return The NombreParts
     */
    public int getNombreParts( )
    {
        return _nNombreParts;
    }

    /**
     * Sets the NombreParts
     * @param nNombreParts The NombreParts
     */ 
    @JsonProperty( "nombreParts" )
    public void setNombreParts( int nNombreParts )
    {
        _nNombreParts = nNombreParts;
    }
    
    /**
     * Returns the _nNombrePersonnesCharge
     * @return The _nNombrePersonnesCharge
     */
    public int getNombrePersonnesCharge( )
    {
        return _nNombrePersonnesCharge;
    }

    /**
     * Sets the _nNombrePersonnesCharge
     * @param nNombrePersonnesCharge The _nNombrePersonnesCharge
     */ 
    @JsonProperty( "nombrePersonnesCharge" )
    public void setNombrePersonnesCharge( int nNombrePersonnesCharge )
    {
        _nNombrePersonnesCharge = nNombrePersonnesCharge;
    }
    
    /**
     * Returns the _nMontantImpot
     * @return The _nMontantImpot
     */
    public int getMontantImpot( )
    {
        return _nMontantImpot;
    }

    /**
     * Sets the _nMontantImpot
     * @param nMontantImpot The _nMontantImpot
     */ 
    @JsonProperty( "montantImpot" )
    public void setMontantImpot( int nMontantImpot )
    {
        _nMontantImpot = nMontantImpot;
    }
    
    /**
     * Returns the _strSituationFamille
     * @return The _strSituationFamille
     */
    public String getSituationFamille( )
    {
        return _strSituationFamille;
    }

    /**
     * Sets the _strSituationFamille
     * @param strSituationFamille The _strSituationFamille
     */ 
    @JsonProperty( "situationFamille" )
    public void setSituationFamille( String strSituationFamille )
    {
        _strSituationFamille = strSituationFamille;
    }
    
    /**
     * Returns the _strAnneeImpots
     * @return The _strAnneeImpots
     */
    public String getAnneeImpots( )
    {
        return _strAnneeImpots;
    }

    /**
     * Sets the _strAnneeImpots
     * @param strAnneeImpots The _strAnneeImpots
     */ 
    @JsonProperty( "anneeImpots" )
    public void setAnneeImpots( String strAnneeImpots )
    {
        _strAnneeImpots = strAnneeImpots;
    }
    
    /**
     * Returns the _strAnneeRevenus
     * @return The _strAnneeRevenus
     */
    public String getAnneeRevenus( )
    {
        return _strAnneeRevenus;
    }

    /**
     * Sets the _strAnneeRevenus
     * @param strAnneeRevenus The _strAnneeRevenus
     */ 
    @JsonProperty( "anneeRevenus" )
    public void setAnneeRevenus( String strAnneeRevenus )
    {
        _strAnneeRevenus = strAnneeRevenus;
    }
    
    /**
     * Returns the Quotient Familial
     * @return The Quotient Familial
     */
    public int getQuotientFamilial()
    {
        return _nRevenuFiscalReference / ( 12 * _nNombreParts );
    }
}