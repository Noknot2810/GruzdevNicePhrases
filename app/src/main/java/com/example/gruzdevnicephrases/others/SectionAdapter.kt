package com.example.gruzdevnicephrases.others

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.databinding.SectionItemBinding
import com.example.gruzdevnicephrases.ui.slist.SListViewModel

class SectionAdapter (
    var sections: List<Section>,
    private val viewModel: SListViewModel
): RecyclerView.Adapter<SectionAdapter.SectionsViewHolder>() {
    class SectionsViewHolder(val binding: SectionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionAdapter.SectionsViewHolder {
        val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionAdapter.SectionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionsViewHolder, position: Int) {
        with(holder.binding) {
            val curSect = sections[position]

            txtSectionName.text = curSect.name

            ivDelete.setOnClickListener {
                viewModel.del_section(curSect)
            }
        }
    }

    override fun getItemCount(): Int {
        return sections.count()
    }
}