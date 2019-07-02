package ahmad.efati.headerview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;


/**
 * Created by Omid Heshmatinia on 12/25/2016.
 */
public class CustomTextView extends AppCompatTextView {
  public CustomTextView(Context context) {
    super(context);
    init(null);
  }

  public CustomTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    //if (!isInEditMode()) {
    //  if (attrs != null) {
    //    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomViewStyle);
    //    int font = a.getInt(R.styleable.CustomViewStyle_mcv_font, 1);
    //    setTypeface(FontManager.getInstance().getFont(font));
    //    a.recycle();
    //  } else {
    //    setTypeface(FontManager.getInstance().getIranSans());
    //  }
    //}
  }
}
