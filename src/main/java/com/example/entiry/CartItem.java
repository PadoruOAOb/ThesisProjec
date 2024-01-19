package com.example.entiry;


	public class CartItem {
		private Integer itemId; // 購物車明細 Id
		private Integer cartId; // 購物車 Id
		private Integer courseId; // 課程 Id
		private Integer price;  // 明細
		private Integer qty; // 數量
		
		private Cart cart; // 購物車物件(關聯欄位)
		private Course course; // 商品物件(關聯欄位)
		
		public Integer getItemId() {
			return itemId;
		}

		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}

		public Integer getCartId() {
			return cartId;
		}

		public void setCartId(Integer cartId) {
			this.cartId = cartId;
		}

		public Integer getCourseId() {
			return courseId;
		}

		public void setCourseId(Integer courseId) {
			this.courseId = courseId;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public Integer getQty() {
			return qty;
		}

		public void setQty(Integer qty) {
			this.qty = qty;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public CartItem() {
			
		}

		@Override
		public String toString() {
			return "CartItem [itemId=" + itemId + ", cartId=" + cartId + ", courseId=" + courseId + ", price=" + price
					+ ", qty=" + qty + ", cart=" + cart + ", course=" + course + "]";
		}
		
		
}

