/*
 * Copyright 2019 iboalali
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * All event classes have to extend this class to be send through the {@link EventBus} and received by the target
 * class.
 * <p>
 * This class has a final method for determining if the from this class extended event is of the intended type.
 */
public abstract class EventObject {
    private boolean mIsSticky = false;

    public final boolean isEventObjectAs(Class klass) {
        return this.getClass().getName().equals(klass.getName());
    }

    public boolean isSticky() {
        return mIsSticky;
    }

    void setSticky(boolean isSticky) {
        mIsSticky = isSticky;
    }
}
