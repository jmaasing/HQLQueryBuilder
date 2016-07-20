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
package nu.zoom.hql;

/**
 *
 * @author Johan Maasing <johan@zoom.nu>
 */
public class HQLBuilderTests {

    public static void main(String[] args) {
        HQLBuilderTests app = new HQLBuilderTests();
        app.run();
    }

    private void run() {
        testSelect();
    }

    private void testSelect() {
        HQLBuilder builder = new HQLBuilder();
        builder
                .select("test")
                .from()
                .as("Test", "test")
                .innerJoin()
                .as("JoinEntity", "je");
        System.out.println(builder.build());
    }
}
