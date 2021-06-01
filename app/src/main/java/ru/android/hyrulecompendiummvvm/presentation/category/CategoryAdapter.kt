package ru.android.hyrulecompendiummvvm.presentation.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image.view.*
import ru.android.hyrulecompendiummvvm.R
import ru.android.hyrulecompendiummvvm.presentation.model.HyruleData

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val mList: MutableList<HyruleData> = mutableListOf()
    private var mListener: Listener? = null

    fun add(lstResultVM: List<HyruleData>) {
        mList.clear()
        mList.addAll(lstResultVM)
        notifyDataSetChanged()
    }

    fun setListener(listener: Listener) {
        mListener = listener
    }

    interface Listener {
        fun onPostClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
    )

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: HyruleData) {

            Glide.with(itemView)
                .load(result.image)
                .into(itemView.imagePreview)

            itemView.cvPostItem.setOnClickListener {

            }
        }
    }
}