package com.example.gruzdevnicephrases.others

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.databinding.SectionItemBinding
import com.example.gruzdevnicephrases.ui.section.SectionActivity
import com.example.gruzdevnicephrases.ui.slist.*

class SectionAdapter (
    var sections: List<Section>,
    private val viewModel: SListViewModel
): RecyclerView.Adapter<SectionAdapter.SectionsViewHolder>() {
    class SectionsViewHolder(val binding: SectionItemBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var cSect: Section? = null

        fun bind(sec: Section){
            cSect = sec
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            //Toast.makeText(v.context, "${cSect!!.name} clicked!", Toast.LENGTH_SHORT / 2).show()

            val intent = Intent(itemView.context, SectionActivity::class.java).apply {  }
            intent.putExtra("section_id", cSect!!.id)
            intent.putExtra("section_name", cSect!!.name)
            startActivity(itemView.context, intent, null)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionAdapter.SectionsViewHolder {
        val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionAdapter.SectionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionsViewHolder, position: Int) {
        with(holder.binding) {
            val curSect = sections[position]

            txtSectionName.text = curSect.name

            ivDelete.setOnClickListener {
                DelSectionDialog(
                    holder.itemView.context,
                    object : DelSectionDialogListener {
                        override fun onDelButtonClicked(item: Section) {
                            viewModel.del_section(item)
                        }
                    },
                    curSect).show()
                //viewModel.del_section(curSect)
            }
        }

        holder.bind(sections[position])
    }

    override fun getItemCount(): Int {
        return sections.count()
    }
}