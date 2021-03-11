package com.teletrac.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teletrac.excercise.adapter.StudentAdapter
import com.teletrac.excercise.data.AllObjects
import com.teletrac.excercise.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() , LifecycleOwner {

    var context: MainActivity? = null
    var viewModel: StudentViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: StudentAdapter? = null
    var pastVisiblesItems:Int = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    var mLayoutManager: LinearLayoutManager? = null
    var isScrolling = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        recyclerView = findViewById(R.id.rv_main)

        viewModel = ViewModelProviders.of(context!!).get(StudentViewModel::class.java)


        viewModel!!.getUserMutableLiveData()?.observe(context!!, userListUpdateObserver)

//        var rf = Retrofit.Builder().baseUrl("https://samples.openweathermap.org/data/2.5/")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//            .create(RetroInterface::class.java)
//
//        GlobalScope.launch (Dispatchers.IO){
//            val response: Response<WeatherResult> = rf.getWeatherData().awaitResponse()
//            if(response.isSuccessful){
//                val data:WeatherResult = response.body()!!
//                Log.d("", data.list.get(0).main.humidity.toString())
//            }
//        }



        mLayoutManager = LinearLayoutManager(this);
//        recyclerView!!.setLayoutManager(mLayoutManager);

//        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true
//                }
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                visibleItemCount = recyclerView.layoutManager!!.getChildCount()
//                totalItemCount = recyclerView.layoutManager!!.getItemCount()
//                pastVisiblesItems = (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
//
//                Toast.makeText(this@MainActivity, "Display Items: " +
//                        recyclerView.adapter!!.itemCount // Just making sure it has correct number of items
////                        viewModel!!.studentArrayList!!.size
//                        + "\nTotal Items: " + viewModel!!.allRecordsArrayList!!.size, Toast.LENGTH_SHORT).show()
//
//                if (isScrolling && (visibleItemCount + pastVisiblesItems == totalItemCount)) {
//                    isScrolling = false
//                    viewModel!!.populateList()
//                    recyclerViewAdapter!!.notifyDataSetChanged()
//                }
//            }
//        })

    }

    var userListUpdateObserver: Observer<ArrayList<AllObjects>> = Observer<ArrayList<AllObjects>> { studentArrayList ->
        recyclerViewAdapter = StudentAdapter(context!!, studentArrayList)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = recyclerViewAdapter
        recyclerView!!.setLayoutManager(recyclerView!!.layoutManager);
    }
}


