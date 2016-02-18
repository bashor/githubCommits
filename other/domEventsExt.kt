package org.w3c.dom.events

@native
interface PopStateEvent : Event {
    var state: Any
}

@native
interface EventHandler : Function1<Event, Unit>
