@file:Suppress("unused")

package kotlinjs.array.ext

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Array<T>.push(e: T): Unit = asDynamic().push(e)

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Array<T>.sort(noinline comparator: (T, T) -> Int): Unit = asDynamic().sort(comparator)
