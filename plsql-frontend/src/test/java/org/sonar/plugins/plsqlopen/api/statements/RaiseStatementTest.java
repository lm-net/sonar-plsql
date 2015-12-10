/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.plsqlopen.api.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.sonar.plugins.plsqlopen.api.PlSqlGrammar;
import org.sonar.plugins.plsqlopen.api.RuleTest;

public class RaiseStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.RAISE_STATEMENT);
    }

    @Test
    public void matchesSimpleRaise() {
        assertThat(p).matches("raise;");
    }
    
    @Test
    public void matchesRaiseException() {
        assertThat(p).matches("raise ex;");
    }
    
    @Test
    public void matchesRaiseMember() {
        assertThat(p).matches("raise pack.ex;");
    }
    
    @Test
    public void matchesLabeledRaise() {
        assertThat(p).matches("<<foo>> raise;");
    }

}
