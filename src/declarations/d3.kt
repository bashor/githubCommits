@file:Suppress("unused")

package d3

@native
object d3 : Selectors<Any> {
    val scale: ScaleBase = noImpl

    fun <T> max(arr: Array<T>): Int = noImpl
    fun <T> max(arr: Array<T>, map: (v: T) -> Int): Int = noImpl
}

@native
interface Selectors<D> {
    fun select(selector: String): Selection<D> = noImpl
    fun selectAll(selector: String): Selection<D> = noImpl
}

@native
interface Selection<D> : Selectors<D> {
    fun attr(name: String): String
    fun attr(name: String, value: Any): Selection<D>
    fun <R> attr(name: String, valueFunction: (data: D) -> R): Selection<D>
    fun <R> attr(name: String, valueFunction: (data: D, index: Int) -> R): Selection<D>
    fun attr(attrValueMap : Any): Selection<D>

    fun classed(name: String): String
    fun classed(name: String, value: Any): Selection<D>
    fun <R> classed(name: String, valueFunction: (data: D, index: Int) -> R): Selection<D>

    fun style(name: String): String;
    fun style(name: String, value: Any, priority: String? = null): Selection<D>;
    fun <R> style(name: String, valueFunction: (data: D) -> R, priority: String? = null): Selection<D>;
    fun <R> style(name: String, valueFunction: (data: D, index: Int) -> R, priority: String? = null): Selection<D>;

    fun text(): String;
    fun text(value: Any): Selection<D>;
    fun text(valueFunction: (data: D) -> Any): Selection<D>
    fun <R> text(valueFunction: (data: D, index: Int) -> R): Selection<D>

    fun <E> data(values: Array<out E>, key: ((data: E, index: Int?) -> String)? = null): UpdateSelection<E>
    fun <E> data(values: (data: Any, index: Int?) -> Array<E>, key: ((data: Any, index: Int?) -> String)? = null): UpdateSelection<E>

    fun append(name: String): Selection<D>

    fun <R> on(eventName: String, listener: (data: D) -> R): Selection<D>
    fun <R> on(eventName: String, listener: (data: D) -> R, capture: Boolean): Selection<D>
    fun <R> on(eventName: String, listener: (data: D, index: Int) -> R): Selection<D>
    fun <R> on(eventName: String, listener: (data: D, index: Int) -> R, capture: Boolean): Selection<D>
}

@native
interface UpdateSelection<D> {
    fun enter(): EnterSelection<D>
}

@native
interface EnterSelection<D> {
    fun append(name: String): Selection<D>
}

@native
interface ScaleBase {
    fun linear(): LinearScale;
}

@native
interface QuantitiveScale : Function1<Any, Any> {
    fun domain(values: Array<out Any>): QuantitiveScale
    fun domain(): Array<Any>

    fun range(values: Array<out Any>): QuantitiveScale
    fun range(): Array<Any>
}

@native
interface LinearScale : QuantitiveScale
