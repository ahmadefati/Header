package ahmad.efati.headerview.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class CustomImageView extends AppCompatImageView {
  public CustomImageView(Context context) {
    super(context);
  }

  public CustomImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public void setOnClickListener(@Nullable final OnClickListener l) {
    super.setOnClickListener(new DebouncedOnClickListener() {
      @Override public void onDebouncedClick(View v) {
        if (l != null) {
          l.onClick(v);
        }
      }
    });
  }
}