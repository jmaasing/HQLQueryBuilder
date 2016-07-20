/*
 * Copyright 2016 Johan Maasing <johan@zoom.nu>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nu.zoom.hql.impl;

import nu.zoom.hql.AsBuilder;
import nu.zoom.hql.FromBuilder;
import nu.zoom.hql.FromClauseBuilder;
import nu.zoom.hql.SelectBuilder;
import nu.zoom.hql.state.AsNode;
import nu.zoom.hql.state.CompoundNode;
import nu.zoom.hql.state.FromNode;
import nu.zoom.hql.state.InnerJoinNode;
import nu.zoom.hql.state.LeftOuterJoinNode;
import nu.zoom.hql.state.SelectNode;

/**
 *
 * @author Johan Maasing <johan@zoom.nu>
 */
public class HQLQueryBuilderImpl implements SelectBuilder, FromBuilder, AsBuilder, FromClauseBuilder {

    private final CompoundNode statementNode = new CompoundNode();

    @Override
    public FromBuilder select(String s) {
        this.statementNode.addNodeLast(new SelectNode(s));
        return this;
    }

    @Override
    public AsBuilder from() {
        this.statementNode.addNodeLast(new FromNode());
        return this;
    }

    @Override
    public FromClauseBuilder as(String entity, String name) {
        this.statementNode.addNodeLast(new AsNode(entity, name));
        return this;
    }

    @Override
    public AsBuilder innerJoin() {
        this.statementNode.addNodeLast(new InnerJoinNode());
        return this;
    }

    @Override
    public AsBuilder leftOuterJoin() {
        this.statementNode.addNodeLast(new LeftOuterJoinNode());
        return this;
    }

    public String build() {
        final StringBuilder sb = new StringBuilder();
        this.statementNode.contribute(sb);
        return sb.toString();
    }
}
