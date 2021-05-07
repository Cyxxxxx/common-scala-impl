package cn.yuc.common

/**
 * 包装断言操作
 * Warp assertion operations up
 * @author YuC
 */
object Asserts {

  /**
   * 断言某个引用是非空的
   * assert anyRef not null
   * @param anyRef any reference type
   * @param errMsg error message
   */
  def notNull(anyRef: AnyRef, errMsg: String): Unit = assert(anyRef != null, errMsg)
}
