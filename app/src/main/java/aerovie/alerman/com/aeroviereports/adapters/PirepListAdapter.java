package aerovie.alerman.com.aeroviereports.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;
import java.util.List;

import aerovie.alerman.com.aeroviedata.types.Pirep;
import aerovie.alerman.com.aeroviereports.R;

/**
 * Created by alerman on 9/30/14.
 */
public class PirepListAdapter extends ArrayAdapter<Pirep> {

    public PirepListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public PirepListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public PirepListAdapter(Context context, int resource, Pirep[] objects) {
        super(context, resource, objects);
    }

    public PirepListAdapter(Context context, int resource, int textViewResourceId, Pirep[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public PirepListAdapter(Context context, int resource, List<Pirep> objects) {
        super(context, resource, objects);
    }

    public PirepListAdapter(Context context, int resource, int textViewResourceId, List<Pirep> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    private static PirepListAdapter instance;

    public static ArrayAdapter<Pirep> getInstance(Context context, int resource, List<Pirep> objects){
        if(instance!= null)
        {
            return instance;
        }else
            return new PirepListAdapter(context,resource,objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.pireplistview, null);

        }

        Pirep pirep = getItem(position);

        TextView pirepTime = (TextView) v.findViewById(R.id.pirepTime);
        TextView pirepInfo = (TextView) v.findViewById(R.id.pirepInfo);
        ImageView imageView = (ImageView) v.findViewById(R.id.pirepIcon);
        String infoString = pirep.getName() + " at " + pirep.getAltitude() + "' reports " + pirep.getRideString();
        pirepInfo.setText(infoString);
        //TODO timestamps not set
        Date pirepDate = new java.util.Date(Long.parseLong(pirep.getPirepTimestamp())*1000);

        PrettyTime pTime = new PrettyTime();
        pirepTime.setText(pTime.format(pirepDate));

        return v;

    }

}
