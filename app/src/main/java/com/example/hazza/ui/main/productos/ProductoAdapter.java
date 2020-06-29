package com.example.hazza.ui.main.productos;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.example.hazza.databinding.ItemProductosBinding;
import com.example.hazza.ui.base.BaseEmptyItemListener;
import com.example.hazza.ui.base.BaseItemListener;
import com.example.hazza.ui.base.BaseRecyclerViewAdapter;
import com.example.hazza.ui.base.BaseViewHolder;
import java.util.List;

public class ProductoAdapter extends BaseRecyclerViewAdapter<ProductoDataItem> {

    private ProductoAdapterListener mListener;

    public ProductoAdapter(List<ProductoDataItem> productoDataItems) {
        super(productoDataItems);
    }

    public void setmListener(ProductoAdapterListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductoAdapter.ProductoViewHolder(ItemProductosBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public int getItemCount() {
        return getItems().size();
    }

    public class ProductoViewHolder extends BaseViewHolder implements ProductoItemViewModel.ProductoItemViewModelListener {

        private ItemProductosBinding mBinding;

        public ProductoViewHolder(ItemProductosBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final ProductoDataItem productoDataItem=getItems().get(position);
            mBinding.setViewModel(new ProductoItemViewModel(productoDataItem,this));
        }

        @Override
        public void onItemClick(ProductoDataItem item) {
            if (item!=null){
                mListener.onItemClick(item);
            }
        }
    }

    public interface ProductoAdapterListener extends BaseItemListener<ProductoDataItem>, BaseEmptyItemListener { }
}
