package com.kickstarter.ui.viewholders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kickstarter.R;
import com.kickstarter.libs.KSString;
import com.kickstarter.libs.utils.ObjectUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UnansweredSurveyHeaderViewHolder extends KSViewHolder {
  private final KSString ksString;

  @Bind(R.id.unanswered_survey_header_text_view) TextView headerTextView;

  public UnansweredSurveyHeaderViewHolder(final @NonNull View view) {
    super(view);
    ButterKnife.bind(this, view);
    this.ksString = environment().ksString();
  }

  @Override
  public void bindData(final @Nullable Object data) throws Exception {
    final int unansweredSurveyCount = ObjectUtils.requireNonNull((int) data);

    if (unansweredSurveyCount > 0) {
      this.headerTextView.setText(
        this.ksString.format(
          "Reward_Surveys",
          unansweredSurveyCount,
          "reward_survey_count",
          String.valueOf(unansweredSurveyCount
          )
        )
      );
    }
  }
}
