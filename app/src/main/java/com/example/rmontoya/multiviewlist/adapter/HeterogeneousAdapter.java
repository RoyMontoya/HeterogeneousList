package com.example.rmontoya.multiviewlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rmontoya.multiviewlist.R;
import com.example.rmontoya.multiviewlist.model.ContentRow;
import com.example.rmontoya.multiviewlist.model.Header;
import com.example.rmontoya.multiviewlist.model.typeinterface.ListElement;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int HEADER = 0;
    private final int CONTENT = 1;
    private List<ListElement> elements;

    public HeterogeneousAdapter(List<ListElement> elements) {
        this.elements = elements;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case HEADER:
                View headerRow = layoutInflater.inflate(R.layout.header_row, parent, false);
                viewHolder = new HeaderViewHolder(headerRow);
                break;
            case CONTENT:
                View contentRow = layoutInflater.inflate(R.layout.content_row, parent, false);
                viewHolder = new ContentViewHolder(contentRow);
                break;
            default:
                View v = layoutInflater.inflate(R.layout.content_row, parent, false);
                viewHolder = new ContentViewHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case HEADER:
                ((HeaderViewHolder) holder).setHeaderText(elements.get(position).exposeValue());
                break;
            case CONTENT:
                ((ContentViewHolder) holder).setContentText(elements.get(position).exposeValue());
                break;
            default:
                ((ContentViewHolder) holder).setContentText(elements.get(position).exposeValue());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (elements.get(position) instanceof Header) return HEADER;
        if (elements.get(position) instanceof ContentRow) return CONTENT;
        return -1;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.header_text)
        TextView headerText;

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setHeaderText(String header) {
            headerText.setText(header);
        }

    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.content_text)
        TextView contentText;

        ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setContentText(String content) {
            contentText.setText(content);
        }

    }

}
