package kotlin.js.array.ext

native
fun <T> Array<T>.push(e: T): Unit = noImpl

native
fun <T> Array<T>.sort(comparator: (T, T) -> Int): Unit = noImpl
