/**
 * 
 */
package frere.netty.heartbeat;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author frere
 *
 */
@Component
public class SpringBeanFactoryUtil implements ApplicationContextAware {
	private static ApplicationContext appCtx;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}

	/**
	 * 获取ApplicationContext
	 * 
	 * @return
	 * @author wangdf
	 */
	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}

	/**
	 * 这是一个便利的方法，帮助我们快速得到一个BEAN
	 * 
	 * @param beanName
	 *            bean的名字
	 * @return 返回一个bean对象
	 * @author wangdf
	 */
	public static Object getBean(String beanName) {
		return appCtx.getBean(beanName);
	}

}
