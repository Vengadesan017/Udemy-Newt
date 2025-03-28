from django import forms
from .models import Form

class ApplicationForms(forms.ModelForm):
    class Meta:
        model = Form
        fields = ['first_name', 'last_name', 'email', 'date', 'occupation']

