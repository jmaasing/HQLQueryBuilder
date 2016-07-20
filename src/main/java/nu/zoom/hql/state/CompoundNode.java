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
package nu.zoom.hql.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nu.zoom.hql.util.Preconditions;

/**
 *
 * @author Johan Maasing <johan@zoom.nu>
 */
public class CompoundNode extends StatementNode {

    private final ArrayList<StatementNode> children = new ArrayList<>();

    public StatementNode addNodeLast(StatementNode node) {
        this.children.add(Preconditions.requireNotNull(node));
        return node;
    }

    public List<StatementNode> getChildern() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void contribute(StringBuilder builder) {
        for (StatementNode child : this.children) {
            child.contribute(builder);
        }
    }
}
