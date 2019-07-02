package ahmad.efati.headerview.customview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomLinearLayout extends LinearLayout {
  public CustomLinearLayout(Context context) {
    super(context);
  }

  public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
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
