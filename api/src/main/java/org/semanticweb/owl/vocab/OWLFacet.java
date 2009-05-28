package org.semanticweb.owl.vocab;

import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Copyright (C) 2006, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group
 * Date: 24-Oct-2006
 * <p/>
 * Represents the facets that can be used for restricting a datatype.
 *
 * @see org.semanticweb.owl.model.OWLFacetRestriction
 * @see org.semanticweb.owl.model.OWLDatatypeRestriction
 */
public enum OWLFacet {

    LENGTH(Namespaces.XSD, "length", "length"),

    MIN_LENGTH(Namespaces.XSD, "minLength", "minLength"),

    MAX_LENGTH(Namespaces.XSD, "maxLength", "maxLength"),

    PATTERN(Namespaces.XSD, "pattern", "pattern"),

    MIN_INCLUSIVE(Namespaces.XSD, "minInclusive", ">="),

    MIN_EXCLUSIVE(Namespaces.XSD, "minExclusive", ">"),

    MAX_INCLUSIVE(Namespaces.XSD, "maxInclusive", "<="),

    MAX_EXCLUSIVE(Namespaces.XSD, "maxExclusive", "<"),

    TOTAL_DIGITS(Namespaces.XSD, "totalDigits", "totalDigits"),

    FRACTION_DIGITS(Namespaces.XSD, "fractionDigits", "fractionDigits"),

    LANG_PATTERN(Namespaces.RDF, "langPattern", "langPattern");


    public final static Set<URI> FACET_URIS;


    static {
        Set<URI> uris = new HashSet<URI>();
        for (OWLFacet v : values()) {
            uris.add(v.getURI());
        }
        FACET_URIS = Collections.unmodifiableSet(uris);
    }


    private URI uri;

    private String shortName;

    private String symbolicForm;


    OWLFacet(Namespaces ns, String shortName, String symbolicForm) {
        this.uri = URI.create(ns + shortName);
        this.shortName = shortName;
        this.symbolicForm = symbolicForm;
    }


    public URI getURI() {
        return uri;
    }

    public String getShortName() {
        return shortName;
    }


    public String getSymbolicForm() {
        return symbolicForm;
    }


    public String toString() {
        return shortName;
    }


    public static Set<URI> getFacetURIs() {
        return FACET_URIS;
    }


    public static OWLFacet getFacet(URI uri) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getURI().equals(uri)) {
                return vocabulary;
            }
        }
        return null;
    }


    /**
     * Gets a facet by its short name
     *
     * @param shortName The short name of the facet.
     * @return The facet or <code>null</code> if not facet by the specified name exists.
     */
    public static OWLFacet getFacetByShortName(String shortName) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getShortName().equals(shortName)) {
                return vocabulary;
            }
        }
        return null;
    }

    public static OWLFacet getFacetBySymbolicName(String symbolicName) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getSymbolicForm().equals(symbolicName)) {
                return vocabulary;
            }
        }
        return null;
    }

    public static Set<String> getFacets() {
        Set<String> result = new HashSet<String>();
        for (OWLFacet v : values()) {
            result.add(v.getSymbolicForm());
        }
        return result;
    }
}