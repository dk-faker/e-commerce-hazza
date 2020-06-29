package com.example.hazza.ui.main.categorias;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.example.hazza.databinding.ItemCategoriasBinding;
import com.example.hazza.ui.base.BaseEmptyItemListener;
import com.example.hazza.ui.base.BaseItemListener;
import com.example.hazza.ui.base.BaseRecyclerViewAdapter;
import com.example.hazza.ui.base.BaseViewHolder;
import java.util.List;

public class CategoariaAdapter extends BaseRecyclerViewAdapter<CategoriaDataItem> {

    private CategoriaAdapterListener mListener;

    public void setmListener(CategoriaAdapterListener mListener) {
        this.mListener = mListener;
    }

    public CategoariaAdapter(List<CategoriaDataItem> categoriaDataItems) {
        super(categoriaDataItems);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoariaAdapter.CategoriaViewHolder(ItemCategoriasBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public int getItemCount() {
        return  getItems().size();
    }


    public class CategoriaViewHolder extends BaseViewHolder implements CategoriaItemViewModel.CategoriaItemViewModelListener {

        private ItemCategoriasBinding mBinding;

        public CategoriaViewHolder(ItemCategoriasBinding binding) {
            super(binding.getRoot());
            this.mBinding=binding;
        }

        @Override
        public void onBind(int position) {
            final CategoriaDataItem categoriaDataItem=getItems().get(position);
            mBinding.setViewModel(new CategoriaItemViewModel(categoriaDataItem,this));
        }

        @Override
        public void onItemClick(CategoriaDataItem categoriaDataItem) {
            if (categoriaDataItem!=null){
                mListener.onItemClick(categoriaDataItem);
            }
        }
    }


    public interface CategoriaAdapterListener extends BaseItemListener<CategoriaDataItem>, BaseEmptyItemListener { }
}
