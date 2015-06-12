package com.project.tranquera.view.mozo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.swing.view.action.ListAction;
import com.common.swing.view.callback.CallbackEdit;
import com.common.swing.view.component.panel.BaseListPanel;
import com.common.swing.view.decorator.ButtonDecorator;
import com.common.swing.view.event.ListEvent;
import com.common.swing.view.listener.ListListener;
import com.common.swing.view.notification.Notificaction;
import com.common.swing.view.notification.util.ConfirmReturnType;
import com.common.swing.view.notification.util.ConfirmType;
import com.crud.swing.view.container.impl.DialogContainer;
import com.crud.swing.view.form.list.BaseListForm;
import com.project.tranquera.business.service.MozoService;
import com.project.tranquera.business.service.TranqueraConverterService;
import com.project.tranquera.domain.model.Mozo;
import com.project.tranquera.view.base.TranqueraButtonDecorator;
import com.project.tranquera.view.mozo.bean.MozoBean;
import com.project.tranquera.view.mozo.component.MozoListPanel;

/**
 * El formulario de Mozos.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoListForm extends BaseListForm<MozoBean> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TranqueraConverterService tranqueraConverterService;

	@Autowired
	private MozoService mozoService;

	@Autowired
	private MozoListPanel mozoListPanel;

	@Autowired
	private MozoEditForm mozoEditForm;

	private DialogContainer dialogContainer;

	@Override
	protected void afterInit() {
		this.dialogContainer = new DialogContainer();
		this.dialogContainer.setModal(true);
		this.dialogContainer.setLocationRelativeTo(null);
		this.setEntities(this.tranqueraConverterService.convert(this.mozoService.findAll(), MozoBean.class));
	}

	@Override
	protected BaseListPanel<MozoBean> createListPanel() {
		return mozoListPanel;
	}

	@Override
	protected Collection<ListAction<MozoBean>> getListActions() {
		List<ListAction<MozoBean>> actions = new ArrayList<ListAction<MozoBean>>();
		actions.add(this.getNuevoAction());
		actions.add(this.getEditarAction());
		actions.add(this.getBorrarAction());
		actions.add(this.getVerAction());
		return actions;
	}

	protected ListAction<MozoBean> getNuevoAction() {
		ListListener<MozoBean> tableListener = new ListListener<MozoBean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void fireEvent(final ListEvent<MozoBean> tableEvent) {
				new Thread() {
					@Override
					public void run() {
						disabled();
						CallbackEdit<MozoBean> callbackEdit = new CallbackEdit<MozoBean>() {
							private static final long serialVersionUID = 1L;

							@Override
							public void confirm(MozoBean entity) {
								System.out.println(entity);
								mozoService.saveOrUpdate(entity.getEntity());
								dialogContainer.dispose();
							}

							@Override
							public void cancel() {
								dialogContainer.dispose();
							}
						};
						dialogContainer.setBody(mozoEditForm);
						mozoEditForm.initNewForm(dialogContainer, callbackEdit, new MozoBean());
						dialogContainer.setVisible(true);
						enabled();
					};
				}.start();
			};
		};

		ButtonDecorator buttonDecorator = new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("Nuevo");
			}
		};
		return new ListAction<MozoBean>(this.getListPanel().getList(), tableListener, buttonDecorator);
	}

	protected ListAction<MozoBean> getEditarAction() {
		ListListener<MozoBean> tableListener = new ListListener<MozoBean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void fireEvent(final ListEvent<MozoBean> tableEvent) {
				new Thread() {
					@Override
					public void run() {
						MozoBean mozoBean = tableEvent.getSelectedEntity();
						if (mozoBean != null) {
							disabled();
							CallbackEdit<MozoBean> callbackEdit = new CallbackEdit<MozoBean>() {
								private static final long serialVersionUID = 1L;

								@Override
								public void confirm(MozoBean entity) {
									System.out.println(entity);
									mozoService.saveOrUpdate(entity.getEntity());
									dialogContainer.dispose();
								}

								@Override
								public void cancel() {
									dialogContainer.dispose();
								}
							};
							dialogContainer.setBody(mozoEditForm);
							mozoEditForm.initEditForm(dialogContainer, callbackEdit, mozoBean);
							dialogContainer.setVisible(true);
							enabled();
						}
					};
				}.start();
			};
		};

		ButtonDecorator buttonDecorator = new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("Editar");
			}
		};
		return new ListAction<MozoBean>(this.getListPanel().getList(), tableListener, buttonDecorator);
	}

	protected ListAction<MozoBean> getBorrarAction() {
		ListListener<MozoBean> tableListener = new ListListener<MozoBean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void fireEvent(final ListEvent<MozoBean> tableEvent) {
				new Thread() {
					@Override
					public void run() {
						if (Notificaction.showConfirmMessage(MozoListForm.this, ConfirmType.YES_NO, "mozo.form.delete.confirm.title",
								"mozo.form.delete.confirm.description") == ConfirmReturnType.YES) {
							disabled();
							Mozo mozo = tableEvent.getSelectedEntity();
							mozoService.deleteById(mozo.getId());
							enabled();
						}
					};
				}.start();
			}
		};
		ButtonDecorator buttonDecorator = new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("BORRAR");
			}
		};
		return new ListAction<MozoBean>(this.getListPanel().getList(), tableListener, buttonDecorator);
	}

	protected ListAction<MozoBean> getVerAction() {
		ListListener<MozoBean> tableListener = new ListListener<MozoBean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void fireEvent(final ListEvent<MozoBean> tableEvent) {
				MozoBean mozoBean = tableEvent.getSelectedEntity();
				if (mozoBean != null) {
					CallbackEdit<MozoBean> callbackEdit = new CallbackEdit<MozoBean>() {
						private static final long serialVersionUID = 1L;

						@Override
						public void confirm(MozoBean entity) {
							System.out.println(entity);
							dialogContainer.dispose();
						}

						@Override
						public void cancel() {
							dialogContainer.dispose();
						}
					};
					dialogContainer.setBody(mozoEditForm);
					mozoEditForm.initViewForm(dialogContainer, callbackEdit, mozoBean);
					dialogContainer.setVisible(true);
				}
			}
		};
		ButtonDecorator buttonDecorator = new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("Ver");
			}
		};
		return new ListAction<MozoBean>(this.getListPanel().getList(), tableListener, buttonDecorator);
	}
}