import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

suspend fun main() {

    val flow = flow{
        for (i in 1..10){
            kotlinx.coroutines.delay(1000)
            emit(i)
        }
    }

    val job = GlobalScope.launch {
        flow.collect {
            delay(2000)
            println(it)
        }
    }
    job.join()
}