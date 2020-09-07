package com.frank.books;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class Book implements Parcelable {

    public String id;
    public String title;
    public String subTitle;
    public String authors;
    public String publisher;
    public String publishDate;
    public String description;
    public String thumbnail;

    public Book(String id, String title, String subTitle,
                String[] authors, String publisher, String publishDate, String description, String thumbnail) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.authors = TextUtils.join(", ", authors);
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    protected Book(Parcel in) {
        id = in.readString();
        title = in.readString();
        subTitle = in.readString();
        authors = in.readString();
        publisher = in.readString();
        publishDate = in.readString();
        description = in.readString();
        thumbnail = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(authors);
        dest.writeString(publisher);
        dest.writeString(publishDate);
        dest.writeString(description);
        dest.writeString(thumbnail);
    }

    @BindingAdapter({"android:imageUrl"})
    public static void loadImage (ImageView view, String imageUrl) {

        if (!imageUrl.isEmpty()){
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.book_open)
                    .into(view);
        }
        else {
            view.setBackgroundResource(R.drawable.book_open);
        }


    }
}
