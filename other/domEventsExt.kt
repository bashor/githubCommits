package org.w3c.dom.events

native
trait PopStateEvent : Event {
    var state: Any
}

native
trait EventHandler : Function1<Event, Unit>
