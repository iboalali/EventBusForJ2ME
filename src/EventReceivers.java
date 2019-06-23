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
 * An interface that a class should implement to receive event via the {@link EventBus}.
 * <p>
 * Usage:
 * <pre>
 * class TestSubscriber implements EventReceivers {
 *     TestSubscriber() {
 *         if (!EventBus.getBus().isSubscribed(this, TestEvent1.class)) {
 *             EventBus.getBus().subscribe(this, TestEvent1.class);
 *         }
 *         if (!EventBus.getBus().isSubscribed(this, TestEvent2.class)) {
 *             EventBus.getBus().subscribe(this, TestEvent2.class);
 *         }
 *     }
 *
 *     public void eventReceiver(EventObject event) {
 *         if (event.isThisEventObject(TestEvent1.class)) {
 *             // handle event
 *         } else if (event.isThisEventObject(TestEvent2.class)) {
 *             // handle event
 *         }
 *     }
 * }
 * </pre>
 */
public interface EventReceivers {
    void eventReceiver(EventObject event);
}
