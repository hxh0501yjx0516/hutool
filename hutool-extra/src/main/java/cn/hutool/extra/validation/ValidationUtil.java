package cn.hutool.extra.validation;

import cn.hutool.extra.validation.BeanValidationResult.ErrorMessage;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * java bean 校验工具类，此工具类基于validation-api（jakarta.validation-api）封装
 *
 * <p>在实际使用中，用户需引入validation-api的实现，如：hibernate-validator</p>
 * <p>注意：hibernate-validator还依赖了javax.el，需自行引入。</p>
 *
 * @author chengqiang
 */
public class ValidationUtil {

	private static final Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * 校验对象
	 *
	 * @param <T>    Bean类型
	 * @param bean   bean
	 * @param groups 校验组
	 * @return {@link Set}
	 */
	public static <T> Set<ConstraintViolation<T>> validate(T bean, Class<?>... groups) {
		return validator.validate(bean, groups);
	}

	/**
	 * 校验bean的某一个属性
	 *
	 * @param <T>          Bean类型
	 * @param bean         bean
	 * @param propertyName 属性名称
	 * @return {@link Set}
	 */
	public static <T> Set<ConstraintViolation<T>> validateProperty(T bean, String propertyName, Class<?>... groups) {
		return validator.validateProperty(bean, propertyName, groups);
	}

	/**
	 * 校验对象
	 *
	 * @param <T>    Bean类型
	 * @param bean   bean
	 * @param groups 校验组
	 * @return {@link BeanValidationResult}
	 */
	public static <T> BeanValidationResult warpValidate(T bean, Class<?>... groups) {
		return warpBeanValidationResult(validate(bean, groups));
	}

	/**
	 * 校验bean的某一个属性
	 *
	 * @param bean         bean
	 * @param propertyName 属性名称
	 * @return {@link BeanValidationResult}
	 */
	public static <T> BeanValidationResult warpValidateProperty(T bean, String propertyName, Class<?>... groups) {
		return warpBeanValidationResult(validateProperty(bean, propertyName, groups));
	}

	/**
	 * 包装校验结果
	 *
	 * @param constraintViolations 校验结果集
	 * @return {@link BeanValidationResult}
	 */
	private static <T> BeanValidationResult warpBeanValidationResult(Set<ConstraintViolation<T>> constraintViolations) {
		BeanValidationResult result = new BeanValidationResult(constraintViolations.isEmpty());
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setPropertyName(constraintViolation.getPropertyPath().toString());
			errorMessage.setMessage(constraintViolation.getMessage());
			result.getErrorMessages().add(errorMessage);
		}
		return result;
	}

}