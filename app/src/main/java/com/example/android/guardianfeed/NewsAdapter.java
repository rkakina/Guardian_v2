package com.example.android.guardianfeed;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each News item
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param articles is the list of News, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the News at the given position
     * in the list of News.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the News at the given position in the list of News
        News currentArticle = getItem(position);

        //Get the section view and pass the section id
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentArticle.getSection());

        //Get the title view and pass the article title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentArticle.getTitle());

        //Get the date view and pass the datetime
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(dateFormat(currentArticle.getDateTimeAsString()));

        //Get the author view and pass the author's name
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(currentArticle.getAuthor());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     *
     * @param dateTimeAsString A datetime in the String format
     * @return A nicer String that doesn't show the T or Z.
     */
    public static String dateFormat(String dateTimeAsString) {
        String currentDateTime = dateTimeAsString;
        String[] separated = currentDateTime.split("T");
        separated[1]=separated[1].substring(0,separated[1].length()-1);
        String fixedDateTime=separated[0]+" "+separated[1];

        return fixedDateTime;
    }

}
