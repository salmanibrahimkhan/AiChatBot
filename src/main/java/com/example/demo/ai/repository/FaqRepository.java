package com.example.demo.ai.repository;

import com.example.demo.ai.model.Faq;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FaqRepository {

    private final List<Faq> faqs = List.of(
        new Faq("How can I reset my password?", "Click on 'Forgot Password' and follow the steps."),
        new Faq("What is the refund policy?", "Refunds are processed within 7 working days."),
        new Faq("How do I change my registered email?", "Go to profile settings and update your email address."),
        new Faq("How can I contact customer support?", "You can contact support via email or live chat."),
        new Faq("What payment methods are accepted?", "We accept credit cards, debit cards, and UPI."),
        new Faq("How do I cancel my subscription?", "Navigate to subscriptions and click on cancel."),
        new Faq("Is my data secure?", "Yes, all data is encrypted and securely stored."),
        new Faq("How do I update my profile information?", "Go to profile section and edit your details."),
        new Faq("Can I change my username?", "Username changes are not supported currently."),
        new Faq("How long does account verification take?", "Account verification usually takes 24 hours."),
        new Faq("process of account verification?", "Account verification please visit the www.xyz.com."),
        new Faq("What should I do if I forget my username?", "Use your registered email to retrieve your username."),
        new Faq("How do I enable two-factor authentication?", "Enable it from the security settings page."),
        new Faq("Why is my payment failing?", "Payment may fail due to bank issues or insufficient balance."),
        new Faq("Can I get an invoice for my payment?", "Yes, invoices are available in the billing section."),
        new Faq("How do I upgrade my plan?", "Go to plans and select the upgrade option."),
        new Faq("Is there a free trial available?", "Yes, we offer a 7-day free trial."),
        new Faq("How do I reset my security questions?", "You can reset them from account security settings."),
        new Faq("Can I access my account from multiple devices?", "Yes, you can log in from multiple devices."),
        new Faq("How do I log out from all devices?", "Use the logout from all devices option in settings."),
        new Faq("What happens if my subscription expires?", "Your account will be downgraded to the free plan."),
        new Faq("How can I reactivate my account?", "Log in and follow the reactivation steps."),
        new Faq("Can I delete my account permanently?", "Yes, permanent deletion is available in account settings."),
        new Faq("How do I change my password?", "Go to security settings and update your password."),
        new Faq("Why didn’t I receive the OTP?", "OTP delays may occur due to network issues."),
        new Faq("How long is the OTP valid?", "OTP is valid for 5 minutes."),
        new Faq("Can I resend the OTP?", "Yes, click on the resend OTP option."),
        new Faq("How do I update my phone number?", "Update your phone number from profile settings."),
        new Faq("What browsers are supported?", "We support Chrome, Firefox, Edge, and Safari."),
        new Faq("Is the application mobile-friendly?", "Yes, the application is fully responsive."),
        new Faq("Do you have a mobile app?", "Yes, our app is available on Android and iOS."),
        new Faq("How do I report a bug?", "Report bugs via the feedback section."),
        new Faq("Can I suggest a new feature?", "Yes, feature requests can be submitted via feedback."),
        new Faq("How do I check system status?", "System status is available on the status page."),
        new Faq("What is the maximum file upload size?", "The maximum upload size is 10 MB."),
        new Faq("Which file formats are supported?", "PDF, DOCX, and JPG formats are supported."),
        new Faq("How do I download my data?", "You can download data from the account section."),
        new Faq("Is customer support available 24/7?", "Yes, support is available round the clock."),
        new Faq("How do I change notification settings?", "Notification preferences can be updated in settings."),
        new Faq("Why am I logged out automatically?", "This may happen due to session timeout."),
        new Faq("How long does a session remain active?", "Sessions remain active for 30 minutes of inactivity."),
        new Faq("Can I use the service internationally?", "Yes, the service is available globally."),
        new Faq("Are there any hidden charges?", "No, there are no hidden charges."),
        new Faq("How do I check my usage details?", "Usage details are available in the dashboard."),
        new Faq("Can I pause my subscription?", "Subscription pause is not supported currently."),
        new Faq("How do I contact sales team?", "You can reach sales via the contact us page."),
        new Faq("Do you offer discounts?", "Discounts are offered during special promotions."),
        new Faq("How do I reset my app settings?", "Reset app settings from the preferences menu."),
        new Faq("my app TIME settings?", "CHANGE IT WITHIN 12 HOURS.")

    );

    public List<Faq> findAll() {
        return faqs;
    }
}
