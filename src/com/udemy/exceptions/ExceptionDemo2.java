package com.udemy.exceptions;

import java.io.IOException;

public class ExceptionDemo2 {
	@SuppressWarnings("unused")
	private static void fileCopyWithARM() throws IOException {
		try (Test t = new Test(); Test2 t2 = new Test2()) {
			throw new IOException("Important Exception");
		}
	}

	@SuppressWarnings("unused")
	private static void fileCopyWithoutARM() throws IOException {
		Test t = null;
		Test2 t2 = null;

		try {
			t = new Test();
			t2 = new Test2();
			throw new IOException("Important Exception");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (t2 != null) {
				t2.close();
			}

			if (t != null) {
				t.close();
			}

		}
	}

	private static void fileCopy2() throws IOException {
		Test t = null;
		Test2 t2 = null;
		int i = 1;
		IOException ioException = null;
		try {
			t = new Test();
			t2 = new Test2();
			if (i == 1) {
				throw new IOException("Important Exception");
			}

		} catch (IOException e) {
			ioException = e;
		} finally {
			if (ioException != null) {
				try {
					t2.close();
				} catch (IOException e) {
					ioException.addSuppressed(e);
				}
			} else {
				try {
					t2.close();
				} catch (IOException e) {
					ioException = e;
				}
			}
			if (ioException != null) {
				try {
					t.close();
				} catch (IOException e) {
					ioException.addSuppressed(e);
				}
				throw ioException;
			} else {
				try {
					t.close();
				} catch (IOException e) {
					e.printStackTrace();;

				}

			}
			
		}
	}

	public static void main(String[] args) {
		try {
			fileCopy2();
		} catch (IOException e) {
			e.printStackTrace();
//			Throwable throwables[] = e.getSuppressed();
//			System.out.println(throwables[0].getMessage());
//			System.out.println(throwables[1].getMessage());
		}

	}
}

class Test implements AutoCloseable {

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		throw new IOException("Trivial Exception");
	}

}

class Test2 implements AutoCloseable {

	@Override
	public void close() throws IOException {
		throw new IOException("Trivial Exception 2");

	}

}