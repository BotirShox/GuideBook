package br.com.byu.guidebook.presentation.ui.guidelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.byu.guidebook.R;
import br.com.byu.guidebook.domain.entity.GuideAggregation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideListAdapter extends RecyclerView.Adapter<GuideListAdapter.ViewHolder> {

    private Context context;
    private List<GuideAggregation> guides;
    //private OnItemClickListener onItemClickListener;

    public GuideListAdapter(Context context, List<GuideAggregation> guides) {
        this.context = context;
        this.guides = guides;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide, parent, false);
        return new ViewHolder(v /*onItemClickListener*/);
    }

    @Override
    public void onBindViewHolder(ViewHolder holders, int position) {
        final ViewHolder holder = holders;
        GuideAggregation guide = guides.get(position);

        if (guide != null) {
            if (!TextUtils.isEmpty(guide.icon)) {
                Picasso.with(context).load(guide.icon).into(holder.icon);
            }
            holder.name.setText(guide.name);
            holder.url.setText(guide.url);
            holder.endDate.setText(guide.endDate);
            holder.startDate.setText(guide.startDate);
        }
    }

    @Override
    public int getItemCount() {
        return guides.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
      //  this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder /*implements  View.OnClickListener*/{

       // OnItemClickListener onItemClickListener;

      /*  public ViewHolder(View v, OnItemClickListener onItemClickListener) {

            super(v);
           // itemView.setOnClickListener(this);
           // this.onItemClickListener = onItemClickListener;
        }*/

        @BindView(R.id.icon)
        ImageView icon;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.end_date)
        TextView endDate;

        @BindView(R.id.url)
        TextView url;

        @BindView(R.id.start_date)
        TextView startDate;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

       /* @Override
        public void onClick(View v) {
           // onItemClickListener.onItemClick(v, getAdapterPosition());
        }*/
    }
}
