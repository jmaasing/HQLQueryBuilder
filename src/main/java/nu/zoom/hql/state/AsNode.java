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

import nu.zoom.hql.util.Preconditions;

/**
 *
 * @author Johan Maasing <johan@zoom.nu>
 */
public class AsNode extends LeafNode {

    private final String entity;
    private final String name;

    public AsNode(String entity, String name) {
        this.entity = Preconditions.requireNotBlank(entity) ;
        this.name = Preconditions.requireNotBlank(name);
    }

    @Override
    public void contribute(StringBuilder builder) {
        builder
                .append(this.entity)
                .append(" AS ")
                .append(this.name)
                .append(" ");
    }

}
