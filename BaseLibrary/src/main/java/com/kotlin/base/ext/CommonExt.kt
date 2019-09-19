package com.kotlin.base.ext

import android.arch.core.executor.DefaultTaskExecutor
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseFunc
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.zip.Deflater
import java.util.zip.DeflaterOutputStream

/*
    扩展Observable执行
 */
fun <T> Observable<T>.excute(
    subscriber: BaseSubscriber<T>,
    lifecycleProvider: LifecycleProvider<*>
) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)

}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            super.onTextChanged(s, start, before, count)
            btn.isEnabled = method()
        }
    })
}

