@Grapes( 
@Grab(group='com.googlecode.libphonenumber', module='libphonenumber', version='7.4.3') 
)
import com.google.i18n.phonenumbers.Phonenumber
import com.google.i18n.phonenumbers.PhoneNumberUtil

// https://github.com/googlei18n/libphonenumber

def func = {
  def util = PhoneNumberUtil.getInstance();
  return {
    def phoneNumber = util.parse(it, "JP");
    util.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
  }
}()

assert func("0451234567") == "045-123-4567"
assert func("0120444444") == "0120-444-444"
assert func("09012345678") == "090-1234-5678"
assert func("110") == "110"
assert func("0312345678") == "03-1234-5678"
