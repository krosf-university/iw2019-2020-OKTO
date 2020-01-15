
// eagerly import theme styles so as we can override them
import "@vaadin/vaadin-charts/theme/vaadin-chart-default-theme";
import "@vaadin/vaadin-lumo-styles/all-imports";


const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>

html {
  --lumo-line-height-m: 1.8;
  --lumo-line-height-s: 1.5;
  --lumo-line-height-xs: 1.3;
  --lumo-border-radius: calc(var(--lumo-size-m) / 2);
  --lumo-base-color: #f7f0f5;
  --lumo-primary-text-color: rgb(48, 102, 190);
  --lumo-primary-color-50pct: rgba(48, 102, 190, 0.5);
  --lumo-primary-color-10pct: rgba(48, 102, 190, 0.1);
  --lumo-primary-color: #3066be;
  --lumo-error-text-color: rgb(255, 0, 4);
  --lumo-tint-5pct: rgba(12, 33, 77, 0.05);
  --lumo-tint-10pct: rgba(12, 33, 77, 0.1);
  --lumo-tint-20pct: rgba(12, 33, 77, 0.2);
  --lumo-tint-30pct: rgba(12, 33, 77, 0.3);
  --lumo-tint-40pct: rgba(12, 33, 77, 0.4);
  --lumo-tint-50pct: rgba(12, 33, 77, 0.5);
  --lumo-tint-60pct: rgba(12, 33, 77, 0.6);
  --lumo-tint-70pct: rgba(12, 33, 77, 0.7);
  --lumo-tint-80pct: rgba(12, 33, 77, 0.8);
  --lumo-tint-90pct: rgba(12, 33, 77, 0.9);
  --lumo-tint: #0c214d;
  --lumo-success-contrast-color: #FFF;
  --lumo-header-text-color: #071013;
  --lumo-body-text-color: #1d2528;
  --lumo-secondary-text-color: #343b3d;
  --lumo-tertiary-text-color: #4a5153;
  --lumo-disabled-text-color: #616668;
  --lumo-shade-5pct: rgba(9, 12, 155, 0.05);
  --lumo-shade-10pct: rgba(9, 12, 155, 0.1);
  --lumo-shade-20pct: rgba(9, 12, 155, 0.2);
  --lumo-shade-30pct: rgba(9, 12, 155, 0.3);
  --lumo-shade-40pct: rgba(9, 12, 155, 0.4);
  --lumo-shade-50pct: rgba(9, 12, 155, 0.5);
  --lumo-shade-60pct: rgba(9, 12, 155, 0.6);
  --lumo-shade-70pct: rgba(9, 12, 155, 0.7);
  --lumo-shade-80pct: rgba(9, 12, 155, 0.8);
  --lumo-shade-90pct: rgba(9, 12, 155, 0.9);
  --lumo-shade: #090c9b;
  --lumo-error-color-50pct: rgba(255, 0, 4, 0.5);
  --lumo-error-color-10pct: rgba(255, 0, 4, 0.1);
  --lumo-error-color: #ff0004;
}

[theme~="dark"] {
  --lumo-base-color: #0c214d;
  --lumo-shade-5pct: rgba(9, 12, 155, 0.05);
  --lumo-shade-10pct: rgba(9, 12, 155, 0.1);
  --lumo-shade-20pct: rgba(9, 12, 155, 0.2);
  --lumo-shade-30pct: rgba(9, 12, 155, 0.3);
  --lumo-shade-40pct: rgba(9, 12, 155, 0.4);
  --lumo-shade-50pct: rgba(9, 12, 155, 0.5);
  --lumo-shade-60pct: rgba(9, 12, 155, 0.6);
  --lumo-shade-70pct: rgba(9, 12, 155, 0.7);
  --lumo-shade-80pct: rgba(9, 12, 155, 0.8);
  --lumo-shade-90pct: rgba(9, 12, 155, 0.9);
  --lumo-shade: #090c9b;
  --lumo-primary-text-color: #b4c5e4;
  --lumo-primary-color-50pct: rgba(48, 102, 190, 0.5);
  --lumo-primary-color-10pct: rgba(48, 102, 190, 0.1);
  --lumo-primary-color: #3066be;
}

  </style>
</custom-style>


<dom-module id="button-style" theme-for="vaadin-button">
  <template>
    <style>:host(:not([theme~="tertiary"])){background-image:linear-gradient(var(--lumo-tint-5pct), var(--lumo-shade-5pct));box-shadow:inset 0 0 0 1px var(--lumo-contrast-20pct);}:host(:not([theme~="tertiary"]):not([theme~="primary"]):not([theme~="error"]):not([theme~="success"])){color:var(--lumo-body-text-color);}:host([theme~="primary"]){text-shadow:0 -1px 0 var(--lumo-shade-20pct);}
    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
