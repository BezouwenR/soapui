/*
 *  soapUI, copyright (C) 2004-2008 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.support.editor.inspectors.wsa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.eviware.soapui.config.MustUnderstandTypeConfig;
import com.eviware.soapui.config.WsaVersionTypeConfig;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockResponse;
import com.eviware.soapui.support.components.SimpleBindingForm;
import com.eviware.soapui.support.editor.xml.XmlInspector;

public class WsdlMockresponseWsaInspector extends AbstractWsaInspector implements XmlInspector, PropertyChangeListener
{
	private final WsdlMockResponse response;

	public WsdlMockresponseWsaInspector( WsdlMockResponse response )
	{
		super( response );
		this.response = response;
	}

	public void propertyChange(PropertyChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	public void buildContent(SimpleBindingForm form)
	{
		form.addSpace( 5 );
		form.appendCheckBox("wsaEnabled", "Enable WS-A addressing", "Enable/Disable WS-A addressing");
		form.addSpace( 5 );
		//add mustUnderstand drop down list
		form.appendComboBox( "mustUnderstand", "Must understand", new String[] {MustUnderstandTypeConfig.NONE.toString(), 
				MustUnderstandTypeConfig.TRUE.toString(), MustUnderstandTypeConfig.FALSE.toString()},
			"The  property for controlling use of the mustUnderstand attribute" );
		
		form.appendComboBox( "version", "WS-A Version", new String[] {WsaVersionTypeConfig.X_200508.toString(), WsaVersionTypeConfig.X_200408.toString()},
			"The  property for managing WS-A version" );
		
		form.appendTextField( "action", "Action", "The action related to a message, will be generated if left empty" );
		form.appendTextField( "from", "From", "The source endpoint reference, will be generated if left empty" );
		form.appendTextField( "replyTo", "Reply to", "The reply endpoint reference, will be generated if left empty" );
		form.appendTextField( "faultTo", "Fault to", "The fault endpoint reference" );
		form.appendTextField( "messageID", "MessageID", " The ID of a message that can be used to uniquely identify a message, will be generated if left empty" );
		form.appendTextField( "replyTo", "Reply to", "The reply endpoint reference, will be generated if left empty" );
		form.appendTextField( "relatesTo", "Relates to", "The endpoint reference Mock Response relates to" );
		form.appendTextField( "relationshipType", "Relationship type", "Relationship type" );
		form.appendTextField( "to", "To", "The destination endpoint reference, will be generated if left empty" );
		form.addSpace( 5 );
	}
}