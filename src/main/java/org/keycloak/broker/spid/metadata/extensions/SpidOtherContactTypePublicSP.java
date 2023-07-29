package org.keycloak.broker.spid.metadata.extensions;

import org.keycloak.broker.spid.SpidIdentityProviderConfig;
import org.keycloak.saml.common.exceptions.ConfigurationException;

class SpidOtherContactTypePublicSP extends SpidOtherContactType {

    public SpidOtherContactTypePublicSP(final SpidIdentityProviderConfig config) throws ConfigurationException {
        super(config);

        // IPA Code
        addExtensionElement("spid:IPACode", config.getIpaCode());

        if(config.isSpAggregator() == true) {
            // VAT Number
            addExtensionElement("spid:VATNumber", config.getVatNumber());
            // Fiscal Code
            addExtensionElement("spid:FiscalCode", config.getFiscalCode());
            // Operator Type
            addQualifier("spid:" + config.getOperatorType());
        } else {
            addQualifier("spid:Public");
        }
    }
}
