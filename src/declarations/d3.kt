package d3

[suppress("UNUSED_PARAMETER")]
native
object d3 : Selectors<Any> {
    val scale: ScaleBase = noImpl

    fun max<T>(arr: Array<T>): Int = noImpl
    fun max<T>(arr: Array<T>, map: (v: T) -> Int): Int = noImpl
}

native
trait Selectors<D> {
    fun select(selector: String): Selection<D> = noImpl
    fun selectAll(selector: String): Selection<D> = noImpl
}

native
trait Selection<D> : Selectors<D> {
    fun attr(name: String): String
    fun attr(name: String, value: Any): Selection<D>
    fun attr<R>(name: String, valueFunction: (data: D) -> R): Selection<D>
    fun attr<R>(name: String, valueFunction: (data: D, index: Int) -> R): Selection<D>
    fun attr(attrValueMap : Any): Selection<D>

    fun classed(name: String): String
    fun classed(name: String, value: Any): Selection<D>
    fun classed<R>(name: String, valueFunction: (data: D, index: Int) -> R): Selection<D>

    fun style(name: String): String;
    fun style(name: String, value: Any, priority: String? = null): Selection<D>;
    fun style<R>(name: String, valueFunction: (data: D) -> R, priority: String? = null): Selection<D>;
    fun style<R>(name: String, valueFunction: (data: D, index: Int) -> R, priority: String? = null): Selection<D>;

    fun text(): String;
    fun text(value: Any): Selection<D>;
    fun text(valueFunction: (data: D) -> Any): Selection<D>
    fun text<R>(valueFunction: (data: D, index: Int) -> R): Selection<D>

    fun data<E>(values: Array<out E>, key: ((data: E, index: Int? = null) -> String)? = null): UpdateSelection<E>
    fun data<E>(values: (data: Any, index: Int?) -> Array<E>, key: ((data: Any, index: Int? = null) -> String)? = null): UpdateSelection<E>

    fun append(name: String): Selection<D>

    fun on<R>(eventName: String, listener: (data: D) -> R): Selection<D>
    fun on<R>(eventName: String, listener: (data: D) -> R, capture: Boolean): Selection<D>
    fun on<R>(eventName: String, listener: (data: D, index: Int) -> R): Selection<D>
    fun on<R>(eventName: String, listener: (data: D, index: Int) -> R, capture: Boolean): Selection<D>
}

native
trait UpdateSelection<D> {
    fun enter(): EnterSelection<D>
}

native
trait EnterSelection<D> {
    fun append(name: String): Selection<D>
}

native
trait ScaleBase {
    fun linear(): LinearScale;
}

native
trait QuantitiveScale : Function1<Any, Any> {
    fun domain(values: Array<out Any>): QuantitiveScale
    fun domain(): Array<Any>

    fun range(values: Array<out Any>): QuantitiveScale
    fun range(): Array<Any>
}

native
trait LinearScale : QuantitiveScale
