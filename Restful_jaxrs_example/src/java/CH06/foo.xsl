<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : foo.xsl
    Created on : 11 September 2017, 18:23
    Author     : abelr
    Description:
        Purpose of transformation follows.
        
    Convierte un xml tipo:
    <customer>
        <first-name>Bill</first-name>
        <last-name>Burke</last-name>
        <street>256ClarendonStreet</street>
        <city>Boston</city>
        <state>MA</state>
        <zip>02115</zip>
        <country>USA</country>
    </customer>
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/customer">
        <cliente>
            <nombre><xsl:value-of select="first-name" /></nombre>
            <apellido><xsl:value-of select="last-name"/></apellido>
            <calle><xsl:value-of select="street"/></calle>
        </cliente>  
    </xsl:template>

</xsl:stylesheet>
