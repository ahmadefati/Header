package ahmad.efati.headerview.customview;




import ahmad.efati.headerview.R;
import ahmad.efati.headerview.R2;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Golrang System
 */
public class HeaderView extends CustomFrameLayout {
  @BindView(R2.id.header_title) CustomTextViewBold headerTitleTv;
  @BindView(R2.id.header_sub_title) CustomTextViewBold headerSubTitleTv;
  @BindView(R2.id.header) CustomFrameLayout rootHeader;
  @BindView(R2.id.layout_header_back) ImageView backButton;
  private String label;
  private String subLabel;
  private int color;
  private int colorBack;
  private int backButtonPadding;
  private int imageBack;

  public HeaderView(Context context) {
    super(context);
  }

  public HeaderView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs);
  }

  private void init(AttributeSet attrs) {

    setAttributes(attrs);

    View view = inflate(getContext(), R.layout.layout_header, null);
    ButterKnife.bind(this, view);
    if (label != null) {
      headerTitleTv.setText(label);
    }
    if (subLabel != null) {
      headerSubTitleTv.setText(subLabel);
    }
    headerTitleTv.setTextColor(color);
    backButton.setColorFilter(colorBack);
    backButton.setImageResource(imageBack);
    backButton.setPadding(backButtonPadding, backButtonPadding, backButtonPadding,
        backButtonPadding);

    addView(view);
  }

  private void setAttributes(AttributeSet attrs) {
    TypedArray a =
        getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0);
    try {
      label = a.getString(R2.styleable.HeaderView_label);
      subLabel = a.getString(R2.styleable.HeaderView_sub_label);
      color = a.getColor(R.styleable.HeaderView_color_txt, 0xff000000);
      colorBack = a.getColor(R.styleable.HeaderView_color_back, 0xff000000);
      imageBack =
          a.getResourceId(R.styleable.HeaderView_back_image, R.drawable.ic_chevron_left_black_24dp);
      backButtonPadding = a.getDimensionPixelSize(R.styleable.HeaderView_back_image_padding, 12);
    } finally {
      a.recycle();
    }
  }

  public void setLabel(String label) {
    this.label = label;
    headerTitleTv.setText(label);
  }

  public void setSubLabel(String subLabel) {
    this.subLabel = subLabel;
    headerSubTitleTv.setText(subLabel);
    headerSubTitleTv.setVisibility(VISIBLE);
  }

  public void setTextColor(Integer color) {
    this.color = color;
    this.headerTitleTv.setTextColor(color);
    //headerTitleTv.setTextColor(Color.parseColor(color)
  }

  public void setColorBackButton(Integer colorBackButton) {
    this.colorBack = colorBackButton;
    this.backButton.setColorFilter(getContext().getResources().getColor(colorBack));
  }

  public void setBackVisible(int visibility) {
    this.backButton.setVisibility(visibility);
  }
}
