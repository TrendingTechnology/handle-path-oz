/*
 * Created by Murillo Comino on 22/06/20 17:50
 * Github: github.com/onimur
 * StackOverFlow: pt.stackoverflow.com/users/128573
 * Email: murillo_comino@hotmail.com
 *
 *  Copyright (c) 2020.
 *  Last modified 21/06/20 20:02
 */

package br.com.onimur.handlepathoz.utils.extension

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default

/**
 * Create a list objects from an object list.
 * This method performs a sequential asynchronous task, which takes longer, but if the user cancels
 * the task, the cancellation call return is much faster if using a multiple asynchronous task.
 *
 * @param T Object of the list
 * @param V Desired object.
 * @param list of the object input
 * @param block function
 */
internal suspend inline fun <T, V> withContextAll(list: List<T>, crossinline block: (T) -> V) =
    list.map { withContext(Default) {
        block.invoke(it) }
    }

/**
 * Similar to the previous method.
 * However, it performs an asynchronous task with multiple calls, which makes it faster,
 * however if the user cancels the task, the cancellation return takes a long time.
 *
 * @param T Object of the list
 * @param V Desired object.
 * @param list of the object input
 * @param block function
 */
internal inline fun <T, V> CoroutineScope.asyncAll(list: List<T>, crossinline block: (T) -> V) =
    list.map { async { block.invoke(it) } }

/**
 * Status Job
 */
internal val Job.wasCancelled: Boolean
    get() = !isActive and isCompleted and isCancelled

internal val Job.wasCompleted: Boolean
    get() = !isActive and isCompleted and !isCancelled

internal val Job.isCancelling: Boolean
    get() = !isActive and !isCompleted and isCancelled

internal val Job.isCompleting: Boolean
    get() = isActive and !isCompleted and !isCancelled

internal val Job.isNew: Boolean
    get() = !isActive and !isCompleted and !isCancelled