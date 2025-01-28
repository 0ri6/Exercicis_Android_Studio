package cat.itb.m78.exercices
/*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel

class ShoppingList :ViewModel(){
    val name = mutableStateOf("")
    val amount = mutableStateOf("")
    val products = mutableStateOf(listOf<Product>())
}

fun changeName(newName: String){
    name.value = newName
}
fun changeAmount(newAmount: String){
    amount.value = newAmount
}
fun add(){
    if (amount.value.toIntOrNull()==null) return
    val newProduct = Product(name.value, amount.value.toInt())
    val newList = products.value+newProduct
    products.value = newList
}


@Composable
fun ShoppingList(
    name: String,
    amount: String,
    products: List<Product>,
    onNameChanged: (String) -> Unit,
    onAmountChanged: (String) -> Unit
){
    Column {
        Card{
            Column {
                Button(onAdd){
                    Text("Add")
                }
            }
            LazyColumn {
                items(products){product ->
                    Card{
                        Row(Modifier.fillMaxWidth()){
                            Text(product.name)
                        }
                    }
                }
            }
        }
    }
}*/