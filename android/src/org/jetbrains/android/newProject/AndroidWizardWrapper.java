package org.jetbrains.android.newProject;

import com.android.tools.idea.npw.NewProjectWizardDynamic;
import com.android.tools.idea.wizard.dynamic.DynamicWizard;
import com.android.tools.idea.wizard.dynamic.DynamicWizardHost;
import com.intellij.ide.util.newProjectWizard.WizardDelegate;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.SettingsStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.ide.wizard.AbstractWizard;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.ui.DialogWrapper;
import icons.AndroidIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Avdeev
 */
public class AndroidWizardWrapper extends ModuleBuilder implements WizardDelegate {

  private NewProjectWizardDynamic myWizard;

  @Override
  public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
  }

  @Override
  public ModuleWizardStep modifyProjectTypeStep(@NotNull SettingsStep settingsStep) {
    return null;
  }

  @Override
  public String getBuilderId() {
    return getClass().getName();
  }

  @Override
  public String getPresentableName() {
    return "Android";
  }

  @Override
  public Icon getNodeIcon() {
    return AndroidIcons.Android;
  }

  @Override
  public String getParentGroup() {
    return JavaModuleType.JAVA_GROUP;
  }

  @Nullable
  @Override
  public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
    if (myWizard == null) {
      myWizard = new NewProjectWizardDynamic(context.getProject(), null, new WizardHostDelegate(context.getWizard()));
      myWizard.init();
    }
    return new ModuleWizardStep() {
      @Override
      public JComponent getComponent() {
        return (JComponent)myWizard.getContentPane();
      }

      @Override
      public void updateDataModel() {

      }
    };
  }

  @NotNull
  @Override
  public ModuleType getModuleType() {
    return JavaModuleType.getModuleType();
  }

  @Override
  public void doNextAction() {
    myWizard.doNextAction();
  }

  @Override
  public void doPreviousAction() {
    myWizard.doPreviousAction();
  }

  @Override
  public void doFinishAction() {
    myWizard.doFinishAction();
  }

  private static class WizardHostDelegate implements DynamicWizardHost {

    private final AbstractWizard myWizard;

    public WizardHostDelegate(@NotNull AbstractWizard wizard) {
      myWizard = wizard;
    }

    @Override
    public Disposable getDisposable() {
      return myWizard.getDisposable();
    }

    @Override
    public void init(@NotNull DynamicWizard wizard) {

    }

    @Override
    public void show() {

    }

    @Override
    public boolean showAndGet() {
      return false;
    }

    @Override
    public void close(@NotNull CloseAction action) {
      myWizard.close(DialogWrapper.CLOSE_EXIT_CODE);
    }

    @Override
    public void shakeWindow() {

    }

    @Override
    public void updateButtons(boolean canGoPrev, boolean canGoNext, boolean canCancel, boolean canFinish) {
      myWizard.updateButtons(canFinish, canGoNext || canFinish, !canGoPrev);
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setPreferredWindowSize(Dimension dimension) {

    }

    @Override
    public void setIcon(@Nullable Icon icon) {

    }

    @Override
    public void runSensitiveOperation(@NotNull ProgressIndicator progressIndicator, boolean cancellable, @NotNull Runnable operation) {
      operation.run();
    }
  }

  private static class Wizard extends NewProjectWizardDynamic {

    public Wizard(@Nullable Project project, @Nullable Module module) {
      super(project, module);
    }

    public boolean hasNext() {
      return super.hasNext();
    }

    public boolean hasPrevious() {
      return super.hasPrevious();
    }
  }
}
