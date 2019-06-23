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
 * A {@link RuntimeException} thrown in cases where a class is not registered to a particular event, an event has no
 * subscriber or a class did not subscribe to any event.
 */
class NotRegisteredException extends RuntimeException {
    NotRegisteredException(Class event) {
        super("No registered subscriber for the event " + event.getName());
    }

    NotRegisteredException(EventReceivers klass) {
        super(klass.getClass().getName() + " did not register any events");
    }

    NotRegisteredException(EventReceivers klass, Object event) {
        super(klass.getClass().getName() + " did not register " + event.getClass().getName());
    }
}
