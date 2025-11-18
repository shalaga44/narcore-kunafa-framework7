package com.narbase.narcore.web.framework7

inline fun <I> objectOf(init: I.() -> Unit): I {
    val result = js("new Object()").unsafeCast<I>()
    init(result)
    return result
}

inline fun <I> objectOf(fromObject: Any? = js("new Object()") as I, init: I.() -> Unit = {}): I {
    val result = fromObject.unsafeCast<I>()
    init(result)
    return result
}
